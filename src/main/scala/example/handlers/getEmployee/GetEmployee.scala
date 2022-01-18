package io.github.minze25.scalamediator
package example.handlers.getEmployee

import core.{IMediator, SingleCommand, SingleCommandHandler}
import example.handlers.Employee

import com.google.inject.Inject
import io.github.minze25.scalamediator.example.handlers.postEmployee.PostEmployeeCommand

case class GetEmployee() extends SingleCommand[Employee]

class GetEmployeeHandler @Inject()(val mediator: IMediator) extends SingleCommandHandler[GetEmployee, Employee] {
  override def handle(command: GetEmployee): Employee = {
    mediator.publish(new PostEmployeeCommand)
    Employee(1, "John")
  }
}
