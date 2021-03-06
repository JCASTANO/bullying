package com.pruebas.ut;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.pruebas.dto.UserDto;
import com.pruebas.exception.ValidatorException;
import com.pruebas.model.TypeProfile;
import com.pruebas.model.User;


/**
 * 
 * @author juan.botero
 *
 */
public class UserTest 
{
	private static final String BOTEROJUANPA_GMAIL_COM = "boterojuanpa@gmail.com";
	private static final String PRUEBA_GMAIL_COM = "prueba@gmail.com";
	private static final String PRUEBA = "Prueba";
	
	/**
	 * @category test
	 */
	@Test
	public void testCreateUserIdNull()
	{
		try {
			new User(null,PRUEBA, PRUEBA_GMAIL_COM,new TypeProfile());
			fail();
		} catch (ValidatorException ve) 
		{
			assertEquals(User.ID_USER_IS_NOT_NULL, ve.getMessage());
		}
	}
	
	/**
	 * @category test
	 */
	@Test
	public void testCreateUserNameNull()
	{
		try {
			new User(123L,null, PRUEBA_GMAIL_COM,new TypeProfile());
			fail();
		} catch (ValidatorException ve) 
		{
			assertEquals(User.NAME_IS_NOT_NULL, ve.getMessage());
		}
	}
	
	/**
	 * @category test
	 */
	@Test
	public void testCreateEmailNull()
	{
		try {
			new User(123L,PRUEBA, null,new TypeProfile());
			fail();
		} catch (ValidatorException ve) 
		{
			assertEquals(User.EMAIL_IS_NOT_NULL, ve.getMessage());
		}
	}
	
	/**
	 * @category test
	 */
	@Test
	public void testCreateProfileNull()
	{
		try {
			new User(123L,PRUEBA, BOTEROJUANPA_GMAIL_COM,null);
			fail();
		} catch (ValidatorException ve) 
		{
			assertEquals(User.PROFILE_IS_NOT_NULL, ve.getMessage());
		}
	}
	
	@Test
	public void testCreate()
	{
		User user = new User(123L,PRUEBA, BOTEROJUANPA_GMAIL_COM,new TypeProfile());
		assertNotNull(user.getIdUserSocial());
		assertNotNull(user.getName());
		assertNotNull(user.getEmail());
		assertNotNull(user.getProfile());
	}
	
	@Test
	public void testCreateUserFromUserDto()
	{
		UserDto userDto = new UserDto();
		userDto.setEmail("prueba@gmail.com");
		userDto.setId(1L);
		userDto.setName("usuario pruebas");
		User user = User.createUserFromUserDto(userDto);
		assertEquals(userDto.getEmail(), user.getEmail());
		assertEquals(userDto.getName(), user.getName());
		assertTrue(userDto.getId() == user.getIdUserSocial());
		
	}
}
