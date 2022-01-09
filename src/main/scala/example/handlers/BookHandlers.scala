package minze25.scalamediator
package example.handlers

import core.{SingleCommand, SingleCommandHandler}

case class Book(title: String, author: String)

case class GetBook() extends SingleCommand[Book]

class GetBookHandler extends SingleCommandHandler[GetBook, Book] {
  override def handle(command: GetBook): Book = Book("The Book", "The Author")
}

case class PostBook() extends SingleCommand[Unit]

class PostBookHandler extends SingleCommandHandler[PostBook, Unit] {
  override def handle(command: PostBook): Unit = println("Posting book...")
}