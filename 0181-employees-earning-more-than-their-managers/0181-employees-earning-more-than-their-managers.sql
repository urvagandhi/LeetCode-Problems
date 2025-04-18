SELECT e2.Name AS Employee
FROM Employee e1
JOIN Employee e2 on e1.id = e2.managerID
WHERE e2.salary > e1.salary;
