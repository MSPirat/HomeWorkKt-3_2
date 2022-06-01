package ru.netology

import org.junit.Test
import org.junit.Assert.*

class NoteServiceTest {

	@Test
	fun addNote() {
		val testNote = NoteService.addNote(Note(0, 1, "title", "text", false))
		val result = NoteService.addNote(note = testNote)
		assertTrue(result.noteId != 0)
		assertEquals(result.noteId,1)
	}

	@Test
	fun createComment() {
		val testNote = NoteService.addNote(Note(2, 1, "title", "text", false))
		val testComment = Comment(1,1,0,1,5,"message",false)
		val result = NoteService.createComment(comment = testComment)
		assertTrue(testComment.commentId != 0)
		assertTrue(NoteService.comments.isNotEmpty())

	}

	@Test (expected = NoteNotFoundException::class)
	fun shouldThrow() {

		val testNote = NoteService.addNote(Note(0,1,"title", "text", false))
		val testComment = Comment(1, 10, 100, 1, 5, "message", false)
		val result = NoteService.createComment(comment = testComment)
	}

	@Test
	fun deleteNote() {
	}

	@Test
	fun deleteComment() {
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