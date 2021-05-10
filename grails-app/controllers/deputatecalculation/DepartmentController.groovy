package deputatecalculation

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class DepartmentController {

    static scaffold = Department

}
