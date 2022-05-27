package ru.netology

import org.junit.Test
import org.junit.Assert.*

class NoteServiceTest {

	@Test
	fun addNote() {
		val testNote = NoteService.addNote(Note(0, 1, "title", "text", privacy = true, deleteId = true))
		val result = NoteService.addNote(note = testNote)
		assertTrue(result.noteId != 0)
	}

	@Test
	fun createComment() { //TODO
//		val testNote = NoteService.add(Note(0, 1, "title", "text", privacy = true, deleteId = true))
//		val testComment = Comment(1,1,0,1,5,"message",1,true)
//		val result = NoteService.createComment(comment = testComment)
//		assertEquals(0, result)
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