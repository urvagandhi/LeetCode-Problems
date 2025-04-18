SELECT p.firstName, p.lastName, a.city, a.state
FROM PERSON p
LEFT JOIN ADDRESS a ON p.personID = a.personID;