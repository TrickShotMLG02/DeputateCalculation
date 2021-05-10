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
        def roleAdmin = new Role(authority: 'ROLE_ADMIN').save()
        def roleUser = new Role(authority: 'ROLE_USER', description: 'User role').save()

        //def admin = new User(username: 'admin', fullname: 'admin', password: springSecurityService.encodePassword('admin'), enabled: true)
        def admin = new User(username: 'Admin', fullname: 'Admin', password: 'admin', enabled: true).save(flush: true)
        def user = new User(username: 'User', fullname: 'User', password: 'user', enabled: true).save(flush: true)
        UserRole.create(admin, roleAdmin, true)
        UserRole.create(user, roleUser, true)
    }

}
