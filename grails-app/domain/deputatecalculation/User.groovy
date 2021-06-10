package deputatecalculation

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String username
    String password
    String surname
    String prename
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

        def setAuthorities(Role role) {
            (UserRole.findAllByUser(this) as List<UserRole>)*.role = role
        }

    static constraints = {
        surname nullable: false
        prename nullable: false
        username nullable: false, unique: true
        password nullable: false, password: true
    }

    static mapping = {
	    password column: '`password`'
    }
}
