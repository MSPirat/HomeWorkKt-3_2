package ru.netology

object NoteService {
	private var notes: MutableList<Note> = mutableListOf()
	private var comments: MutableList<Comment> = mutableListOf()
	private var nextNoteId: Int = 0
	private var nextCommentId: Int = 0

	fun addNote(note: Note): Note {
		notes += if (notes.isEmpty()) {
			note.copy(noteId = 0)
		} else {
			note.copy(noteId = nextNoteId)
		}
		nextNoteId++
		return notes.last()
	}

	fun createComment(comment: Comment) {
		var createComment = false
		for (newNote in notes) {
			if (newNote.noteId == comment.noteId && !newNote.deleteId) {
				comments += if (comments.isEmpty()) {
					comment.copy(commentId = 0)
				} else {
					comment.copy(commentId = nextCommentId)
				}
				nextCommentId++
				createComment = true
			}
		}
		if (!createComment) {
			throw CommentNotFoundException("Comment not found")
		}
	}

	fun deleteNote(noteId: Int) {
		var deleteNote = false
		for (newNote in notes) {
			if (newNote.noteId == noteId && !newNote.deleteId) {
				notes[newNote.noteId] = newNote.copy(deleteId = true)
				deleteNote = true
			}
		}
		if (!deleteNote) {
			throw NoteNotFoundException("Note not found")
		}
	}

	fun deleteComment(commentId: Int) {
		var deleteComment = false
		for (newComment in comments) {
			if (newComment.commentId == commentId && !newComment.deleteId) {
				comments[newComment.commentId] = newComment.copy(deleteId = true)
				deleteComment = true
			}
		}
		if (!deleteComment) {
			throw CommentNotFoundException("Comment not found")
		}
	}

	fun editNote(noteId: Int, note: Note): Note {
		var editNote = false
		for (newNote in notes) {
			if (newNote.noteId == noteId && !newNote.deleteId) {
				notes[noteId] = newNote
				editNote = true
			}
		}
		if (!editNote) {
			throw NoteNotFoundException("Note not found")
		}
		return note
	}

	fun editComment(commentId: Int, comment: Comment): Comment {
		var editComment = false
		for (newComment in comments) {
			if (newComment.commentId == commentId && !newComment.deleteId) {
				comments[commentId] = newComment
				editComment = true
			}
		}
		if (!editComment) {
			throw CommentNotFoundException("Comment not found")
		}
		return comment
	}

	fun getNote(user: User): MutableList<Note> {
		var getNote = false
		val userGetNote: MutableList<Note> = mutableListOf()
		for (newNote in notes) {
			if (newNote.ownerId == user.userId && !newNote.deleteId) {
				userGetNote.add(newNote)
				getNote = true
			}
		}
		if (!getNote) {
			throw NoteNotFoundException("Note not found")
		}
		return userGetNote
	}

	fun getNoteById(noteId: Int): MutableList<Note> {
		var getNoteById = false
		val getNote: MutableList<Note> = mutableListOf()
		for (newNote in notes) {
			if (newNote.noteId == noteId && !newNote.deleteId) {
				getNote.add(newNote)
				getNoteById = true
			}
		}
		if (!getNoteById) {
			throw NoteNotFoundException("Note $noteId not found")
		}
		return getNote
	}

	fun getComment(commentId: Int) {
		var getComment = false
		val getCommentNote: MutableList<Comment> = mutableListOf()
		for (newComment in comments) {
			if (newComment.commentId == commentId && !newComment.deleteId) {
				getCommentNote.add(newComment)
				getComment = true
			}
		}
		if (!getComment) {
			throw CommentNotFoundException("Comment not found")
		}
	}

	fun restoreComment(commentId: Int) {
		var restoreComment = false
		for (newComment in comments) {
			if (newComment.commentId == commentId && newComment.deleteId) {
				comments[commentId] = newComment.copy(deleteId = false)
				restoreComment = true
			}
		}
		if (!restoreComment) {
			throw CommentNotFoundException("Comment not found")
		}
	}
}
