package minze25.scalamediator
package minze25.scalamediator.example.app.handlers.postEmployee

import core.{MultiCommand, MultiCommandHandler}


case class PostEmployeeCommand() extends MultiCommand

class PostEmployeeHandler extends MultiCommandHandler[PostEmployeeCommand] {
  override def handle(command: PostEmployeeCommand): Unit = println("Posting employee")
}