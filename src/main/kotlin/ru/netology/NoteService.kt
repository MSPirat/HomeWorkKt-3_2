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
		var addComment = false
		for (newNote in notes) {
			if (newNote.noteId == comment.noteId && !newNote.deleteId) {
				comments += if (comments.isEmpty()) {
					comment.copy(commentId = 0)
				} else {
					comment.copy(commentId = nextCommentId)
				}
				nextCommentId++
				addComment = true
			}
		}
		if (!addComment) {
			throw CommentNotFoundException("Comment not found")
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

		fun editNote(noteId: Int, newNote: Note): Note {
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
			return newNote
		}

		fun editComment(commentId: Int, newComment: Comment): Comment {
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
			return newComment
		}

	}
}