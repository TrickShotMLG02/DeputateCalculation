package deputatecalculation

import grails.gorm.transactions.Transactional

class BootStrap {

    def init = { servletContext ->
        addDefaults()
        addDefaultAuth()
    }
    def destroy = {
    }

    @Transactional
    void addDefaults() {
        def depScience = new Department(name: "Science").save(flush: true)
        def depGeneralKnowledge = new Department(name: "General Knowledge").save(flush: true)
        def teacher1 = new Teacher(surname: "Max", name: "Mustermann", shortname: "mm", email: "max.mustermann@schule.de", birthdate: new Date(), department: depScience).save(flush: true)
    }

    @Transactional
    void addDefaultAuth() {
        def roleAdmin = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def roleUser = new Role(authority: 'ROLE_USER', description: 'User role').save(flush: true)
        def roleDepartmentHead = new Role(authority: 'ROLE_DEPARTMENT_HEAD').save(flush: true)

        def admin = new User(username: 'Admin', fullname: 'Admin', password: 'admin', enabled: true).save(flush: true)
        def user = new User(username: 'User', fullname: 'User', password: 'user', enabled: true).save(flush: true)

        UserRole.create(admin, roleAdmin, true)
        UserRole.create(user, roleUser, true)
        UserRole.create(user, roleAdmin, true)

        /*
            To manually create a new user with a specific role, use the create-method on the UserRole-table.
            This will create a new entry in the specific table.
         */
    }

}
