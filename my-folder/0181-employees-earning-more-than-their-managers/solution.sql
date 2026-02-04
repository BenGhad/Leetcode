-- Write your PostgreSQL query statement below
SELECT e.name as Employee
FROM Employee e INNER JOIN Employee e2
ON e.managerId = e2.id AND e.salary > e2.salary;
