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
			if (newNote.noteId == comment.noteId && !newNote.deletedId) {
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
			throw CommentNotFoundException("Note not found")
		}

		fun deleteNote(noteId: Int) {
			TODO()
		}

		fun deleteComment(commentId: Int) {
			TODO()
		}

	}
}