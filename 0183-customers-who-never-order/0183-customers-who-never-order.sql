SELECT c.name AS Customers
FROM Customers c
LEFT JOIN Orders o ON c.ID = o.customerID
WHERE o.ID IS NULL;