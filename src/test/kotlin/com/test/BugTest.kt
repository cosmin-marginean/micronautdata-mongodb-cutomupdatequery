package com.test

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

@MicronautTest
class BugTest {

    @Inject
    lateinit var repository: BookRepository

    @Test
    fun test() {
        val book = repository.save(Book(title = "notitle"))

        val updatedBook = repository.updateTitle(book.id)

        // This passes
        assertEquals("New title", repository.findById(book.id).get().title)

        // This fails
        assertNotNull(updatedBook)
    }
}