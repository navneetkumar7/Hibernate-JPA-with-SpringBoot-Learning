- **JDBC:** Java database connectivity
- **JPA:** Java persistent API    
- JPA is standard for doing object relational mapping. (mapping of objects to tables)
- think of JPA as an interface and Hibernate is implementation.
- If there is in memory db, then hibernate default feature of schema update will create the table in db.
- Named Query: jpql:java persistence query language
- Entity manager: Entity manager is simple interface to PersistenceContext
- **Annotations:** @Entity @TABLE @Column @Id @GeneratedValue
- JPQL: Java persistence query language
  - In SQl we query from the db, in JPQL  we query from Entities. JPQL queries are converted into sql queries by JPA implementation i.e Hibernate
- NamedQuery: Assign name to query for reusability purpose;

- When to gor for native queries:
    - when you want to use some feature of db which is not supported by JPA, mass update, tuning features.
- Eager Fetching:
    - one to one relationship , when we pull the one entity other one also pulled automatically.
    - this can be performance hit.
- Lazy Fetching:
    -  put fetch type at entity mapping : **@OneToOne(fetch = FetchType.LAZY)**

      - Transaction:
        public void someTest()
            {
                //Database operation 1: Retrieve student
                Student student = em.find(Student.class,20001);
                //Persistence Context(student)

                //Database operation 2: Retrieve passport
                Passport passport=student.getPassport();
                //Persistence Context(student, passport)
        
                //Database operation 3: update passport
                passport.setNumber("G2389");
                //Persistence Context(student, passport++)
        
                //Database operation 4: update student
                student.setName("Navneet-updated");
                //Persistence Context(student++, passport++)
        
            }

- transaction will be sent to db at the end of the block.
- Persistence Context
  - To temp store entities we are operating in
  - To give access to db
- In JPA we interact with Persistence context through Entity Manager Interface.
- If there is no @Transactional on method then transaction is create for the individual db query and will be closed just after it.
- In Hibernate
  - session= Persistence Context
  - session Factory = EntityManager
- Persistence Context is created at the start of transaction and is closed at the end of transaction.
- @OneToOne
  - default fetch strategy is eager
  - Uni-directional : When we can pull details of related entity from the owning entity only. 
  - Owning side of relation: Entity which, has the identifier stored of the other Entity, having relation with.
  - Bi-directional relation: When we can pull details of either entity either through owning entity or owned entity
- Put **mappedBy** in Entity which doesn't own the relationship: **@OneToOne(fetch = FetchType.LAZY, mappedBy = "name of the field in owning side thorugh which it is mapped to other entity")**
- @OneToMany
  - default fetch strategy is Lazy: meaning if one entity has one to many relation with another entity, if we pull the entity with 1:M then only that entity will be pulled default
- @ManyToOne
  - default fetch strategy is Eager: meaning if one entity has many to one relation with another entity, if we pull the entity with M:1 then  entity will the other entity as well
- @ManyToMany
  - default fetch strategy is Lazy
  - @JoinTable(name = "mapping table name", joinColumns = @JoinColumn(name = "owning side column name"), inverseJoinColumns = @JoinColumn(name = "other side of column name"))
  - @JoinTable will be put on owning side
- **Owning side should have the relationship defined (add reference of other into owning one)in java  code then only mapping will be set in DB**