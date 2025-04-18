CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    DECLARE offsetVal INT;
    SET offsetVal = N-1;

    RETURN (
        SELECT(
            SELECT DISTINCT SALARY 
            FROM Employee 
            ORDER BY salary DESC
            LIMIT 1 OFFSET offsetVal
        )
    );
END