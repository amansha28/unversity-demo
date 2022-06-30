==== University Demo Project ====
    1.0 Outline of the Project
        1.1 Project is built using SpringBoot's web and JPA modules, on database side we have used Postgres and H2 db to test.-- more details can be    found in pom.xml file.
        1.2 There are majorily 4 Controllers , 1 each for : Department, Professor, Course, Schedule.
        1.3 Each of these controllers contains various REST endpoints to perform Create, Read , Delete operations.
        1.3 An mentioned a GET REST endpoint "/search" has been implemented which retrieves the data according to specifications in assignment file.
            a) Filtering & Aggregation logic has been given in the file : src/main/java/com/example/universitydemo/dao/ScheduleRepo.java
        1.4 Project follows the following flow of code : Controller -> Service -> Repository (JPA Repository).
 

    2.0 Database Outline
        2.1 Tables should be created in following order : 
            a) Department : This is the parent table
            b) Professor/Course : These 2 tables can be created in any order but after Department table as they need to maintain referential integrity to Department table.
            c) Schedule : This table should be the last one to be created after above 3 layers as it needs to maintain referential integrity to Department table.
        2.2 Tables have following relationships : 
            a) Department  : Master Table - Primary Key -> id
            b) Professor : Primary Key -> id
                Many-to-One uni-directional relationship with Deparment - Many Professors can belong to 1 department.
                One-to-Many uni-directional relatonship with Schedule - One Professor can belong to multiple rows in Schedule table.
            c) Course : Primary Key -> id
                Many-to-One uni-directional relationship with Department - Many Course can belong to 1 department.
                One-to-Many uni-directional relatonship with Schedule - One Course can belong to multiple rows in Schedule table.
            d) Schedule : Composite Key -> professor_id,course_id, semester, year
         2.3 For simiplicity purpose, we have given "year_taught" as column name in Schedule table instead of "year".
         2.4 Triggers can be configured to get invoked to automatically delete entries from child tables when entry is deleted from Parent table. But currently, Hibernate takes care of same.
            For eg : When an entry is deleted from Department table, It automatically deletes related records from Professor, Course table.
         2.5 Parent entry should exits before associating child to it.
            Eg : While adding new professor, the corresponding department should exists.   

    3.0 Improvements :
        3.1) From Java side : 
            a) Project Lombok could have been used as it will minimize the code by providing annotation based features for Constructors and Getter/Setters
            b) Unit tests are currently not added due to the limited time constraint but plan to add it soon. 
            c) Abstraction can be introduced for each Layer like Service and Repository if the number of functionalities were more.
            d) Native Query to Entity projections can improved from Inteface-based DTO to DTO as it removes the overhead of following activity :  At runtime, Spring Data JPA generates a Java class that implements that interface (of interface-based DTO).
            6) In case of huge number of records we should make use of type Pageable of your repository. This will help improve performance.
            7) Hibernate makes pesistance easier hence which makes it easier for the developers to understand the code. But SQL (like Spring JDBC) can be used for better performance, especially when running complex queries with huge number of tables that are densely related to each other.
        3.2) From DB side : 
            a) As mentioned earlier Triggers can be used to make avoid orphan records.
            b) Indexing should be applied on the columns of the tables which on data is frequently searched to speed-up the query.
            c) In case DB table size becoming huge we should perform the Horizontal sharding.
            d) In order to shift the work from application to server space we can use Stored procedures as it can help fetch, process and filter data before giving it to application, this can be used to combine multiple sequential queries saving I/O costs also.

                