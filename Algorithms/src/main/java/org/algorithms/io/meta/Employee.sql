select e.name as Employee from Employee e, Employee e1
where e.managerId = e1.id and e.salary > e1.salary; 
