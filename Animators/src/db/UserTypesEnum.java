/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author Оксана
 */
public enum UserTypesEnum {
    User(0, "Пользователь"), Admin(1, "Администратор"), Client(2, "Клиент"), Personage(3, "Персонаж");
    
    private int value;
    private String description;

    private UserTypesEnum(int value, String description) {
	this.value = value;
	this.description = description;
    }

    public int getValue() {
	return this.value;
    }

    public String getDescription() {
	return this.description;
    }
    
    @Override
    public String toString() {
	return this.description;
    }
    
}
