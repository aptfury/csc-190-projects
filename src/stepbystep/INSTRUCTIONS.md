# Instructions

> [!Note]
> This is a project assigned by the instructor of my Java Programming Course. The instructions are not my own nor ar 
they specific to or from the course material. My solutions are kept here for easier access and personal reference in 
the future.
> 
> _**Credit to [CodeStepByStep](https://www.codestepbystep.com/) for the coding problem.**_

Define a class named Student. A Student object represents a university student that, for simplicity, just has a name,
ID number, and number of units earned towards graduation. Each Student object should have the following public behavior:

- new Student(name, id)
  - Constructor that initializes a new Student object storing the given name and ID number, with 0 units.
- s.getName()
- s.getID()
- s.getUnits()
  - Returns the name, ID, or unit count of the student, respectively.
- s.incrementUnits(units);
  - Adds the given number of units to this student's unit count.
- s.hasEnoughUnits()
  - Returns whether the student has enough units (180) to graduate.
- s.toString()
  - Returns the student's string representation, e.g. "Nick (#42342)".