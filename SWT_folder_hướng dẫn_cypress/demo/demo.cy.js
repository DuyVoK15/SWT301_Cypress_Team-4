/// <reference types="cypress" />

describe('Flowshop test',()=>{
    it('Login test invalid email, password', () => {
        cy.visit('http://localhost:8080/FlowerManagementSystem/')
        cy.get(':nth-child(6) > a').click()
        cy.wait(1000)
        cy.get(':nth-child(1) > :nth-child(2) > input').type('hieunmt@gmaill.com')
        cy.wait(1000)
        cy.get(':nth-child(2) > :nth-child(2) > input').type('adadsa')
        cy.wait(1000)
        cy.get(':nth-child(3) > td > input').click()
        cy.wait(1000)
        cy.get('body > :nth-child(1)').contains('invalid email')
    });
    it('Login test success', () => {
        cy.visit('http://localhost:8080/FlowerManagementSystem/')
        cy.get(':nth-child(6) > a').click()
        cy.wait(1000)
        cy.get(':nth-child(1) > :nth-child(2) > input').type('hieunmt@gmaill.com')
        cy.wait(1000)
        cy.get(':nth-child(2) > :nth-child(2) > input').type('se150772')
        cy.wait(1000)
        cy.get(':nth-child(3) > td > input').click()
        cy.wait(1000)
        cy.get(':nth-child(5) > a').click()
        cy.get(':nth-child(1) > h3').contains('hieu dep trai')
    });
})