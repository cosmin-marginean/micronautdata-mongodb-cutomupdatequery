package com.test

import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.mongodb.annotation.MongoUpdateQuery
import io.micronaut.data.repository.CrudRepository

@MongoRepository
interface BookRepository : CrudRepository<Book, String> {

    @MongoUpdateQuery(filter = "{_id: {\$eq: :id}}", update = "{\$set:{title: \"New title\" }}")
    fun updateTitle(id: String): List<Book>

}