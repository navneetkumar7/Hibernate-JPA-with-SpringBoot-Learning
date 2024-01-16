JDBC: Java database connectivity
JPA: Java persistent API    
    - JPA is standard for doing object relational mapping. (mapping of objects to tables)
    - think of JPA as an interface and Hibernate is implementation.
    - If there is in memory db, then hibernate default feature of schema update will create the table in db.
    - Named Query: jpql:java persistence query language
Entity manager: Entity manager is simple interface to PersistenceContext
JPQL: Java persistence query language
    - In SQl we query from the db, in JPQL  we query from Entities. JPQL queries are converted into sql queries by JPA implementation i.e Hibernate
NamedQuery: Assign name to query for reusability purpose;

When to gor for native queries:
    - when you want to use some feature of db which is not supported by JPA, mass update, tuning features.