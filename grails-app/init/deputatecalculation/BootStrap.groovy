package deputatecalculation

import grails.gorm.transactions.Transactional

class BootStrap {

    def init = { servletContext ->
        addDefaultAuth()
    }
    def destroy = {
    }

    @Transactional
    void addDefaultAuth() {

        //create roles
        def roleTeacher = new Role(authority: 'ROLE_TEACHER').save()
        def roleAdmin = new Role(authority: 'ROLE_ADMIN').save()
        def roleUser = new Role(authority: 'ROLE_USER', description: 'User role').save()

        //create departments
        def depScience = new Department(name: "Science").save(flush: true)
        def depGeneralKnowledge = new Department(name: "General Knowledge").save(flush: true)

        //create users (non-teachers)
        def admin = new User(username: 'Admin', surname: 'min', prename: 'Ad', password: 'admin', enabled: true).save(flush: true)
        def user = new User(username: 'User', surname: 'er', prename: 'Us', password: 'user', enabled: true).save(flush: true)

        //create teachers
        def hr = new Teacher(username: "nh", surname: "ham", prename: "nik", password: "hr", enabled: true, abbreviation: "hr", email: "hr@abc.de", birthdate: new Date(), department: depGeneralKnowledge).save(flush: true)

        //assign roles to users (non-teachers)
        UserRole.create(admin, roleAdmin, true)
        UserRole.create(user, roleUser, true)

        //assign roles to teachers
        UserRole.create(hr, roleAdmin, true)

        /*
            To manually create a new user with a specific role, use the create-method on the UserRole-table.
            This will create a new entry in the specific table.
            s
            s
            s
         */
    }

}
