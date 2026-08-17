SELECT MAX(Salary) AS SecondHighestSalary
FROM Employee
WHERE Salary < (Select MAX(Salary) FROM Employee);