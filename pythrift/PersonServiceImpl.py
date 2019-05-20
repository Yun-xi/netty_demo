# _*_ coding:utf-8 _*_
__author__ = '作者'

from py.thrift.generated import ttypes

class PersonServiceImpl:

    def getPersonByUsername(self, username):
        print "Got client param: " + username

        person = ttypes.Person
        person.username = username
        person.age = 20

        return person

    def savePerson(self, person):
        print "Got client param"

        print person.username
        print person.age
        print person.married