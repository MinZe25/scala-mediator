package io.github.minze25.scalamediator
package example.handlers.getEmployee

import core.{SingleCommand, SingleCommandHandler}

import example.handlers.Employee

case class GetEmployee() extends SingleCommand[Employee]

class GetEmployeeHandler extends SingleCommandHandler[GetEmployee, Employee] {
  override def handle(command: GetEmployee): Employee = Employee(1, "John")
}
