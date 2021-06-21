package deputatecalculation

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='authority')
@ToString(includes='authority', includeNames=true, includePackage=false)
class Role implements Serializable {

	String authority

	static constraints = {
		authority nullable: false, blank: false, unique: true
	}

	//static mapping = {
	//	cache true
	//}

	String toString() {
		authority
	}
}
