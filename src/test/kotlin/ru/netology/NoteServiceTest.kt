package ru.netology

import org.junit.Test
import org.junit.Assert.*

class NoteServiceTest {

	@Test
	fun addNote() {
		val testNote = NoteService.addNote(Note(0, 1, "title", "text", false))
		val result = NoteService.addNote(note = testNote)
		assertTrue(NoteService.notes.isNotEmpty())
		assertTrue(result.noteId != 0)
		assertEquals(result.noteId, 1)
	}

	@Test
	fun createComment() {
		val testNote = NoteService.addNote(Note(1, 1, "title", "text", false))
		val testComment = Comment(1, 1, 0, 1, 5, "message", false)
		val result = NoteService.createComment(comment = testComment)
		assertTrue(NoteService.comments.isNotEmpty())
		assertTrue(testComment.commentId != 0)
	}

	@Test(expected = CommentNotFoundException::class)
	fun createCommentShouldThrowException() {
		val testNote = NoteService.addNote(Note(0, 1, "title", "text", false))
		val testComment = Comment(1, 10, 100, 1, 5, "message", false)
		val result = NoteService.createComment(comment = testComment)
	}

	@Test
	fun deleteNote() {
		val testNoteFirst = NoteService.addNote(Note(1, 1, "title", "text", false))
		val testNoteSecond = NoteService.addNote(Note(2, 1, "title", "text", false))
		val result = NoteService.deleteNote(noteId = 1)
		assertTrue(NoteService.notes.isNotEmpty())
	}

	@Test(expected = NoteNotFoundException::class)
	fun deleteNoteShouldThrowException() {
		val testNoteFirst = NoteService.addNote(Note(1, 1, "title", "text", false))
		val testNoteSecond = NoteService.addNote(Note(2, 1, "title", "text", false))
		val result = NoteService.deleteNote(noteId = 10)
	}

	@Test
	fun deleteComment() { //TODO
//		val testNote = NoteService.addNote(Note(1, 1, "title", "text", false))
//		val testCommentFirst = Comment(1, 1, 1, 1, 5, "message", false)
//		val testCommentSecond = Comment(2, 1, 1, 1, 5, "message", false)
//		NoteService.createComment(testCommentFirst)
//		NoteService.createComment(testCommentSecond)
//		val result = NoteService.deleteComment(commentId = 1)
//		assertTrue(NoteService.comments.isNotEmpty())
	}

	@Test
	fun editNote() {
	}

	@Test
	fun editComment() {
	}

	@Test
	fun getNote() {
	}

	@Test
	fun getNoteById() {
	}

	@Test
	fun getComment() {
	}

	@Test
	fun restoreComment() {
	}
}