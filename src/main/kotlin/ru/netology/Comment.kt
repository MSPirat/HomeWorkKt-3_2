package ru.netology

data class Comment(
	val commentId: Int,
	val ownerCommentId: Int,
	val noteId: Int,
	val ownerId: Int,
	val date: Int,
	val message: String,
	val count: Int,
)
