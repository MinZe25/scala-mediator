package minze25.scalamediator
package minze25.scalamediator.example.app.handlers.getEmployee

import core.{SingleCommand, SingleCommandHandler}

case class GetEmployee() extends SingleCommand[Employee]

class GetEmployeeHandler extends SingleCommandHandler[GetEmployee, Employee] {
  override def handle(command: GetEmployee): Employee = Employee(1, "John")
}
