/*
 * @(#)MD5.java	1.0	10.02.12
 *
 * Copyright 2010 ma3r. All rights reserved.
 */

package com.yodata.creditsupport.util;

import java.security.MessageDigest;

/**
 * A utility to generate MD5 digest conveniently.
 *
 * @author	ma3r
 * @version	1.0, 10.02.12
 * @since	1.0
 */
public class MD5
{
	/**
	 * To generate MD5 digest for the specified string.
	 *
	 * @param	string	The specified string to generate digest.
	 * @return	The generated MD5 digest for the string.
	 */
	public static String digest( String string )
	{
		StringBuilder sb = new StringBuilder();
		try
		{
			// Generate all MD5 bytes for the string.
			MessageDigest md5 = MessageDigest.getInstance( "MD5" );
			byte[] bytes = md5.digest( string.getBytes( "UTF-8" ) );

			// Assamble all the bytes into a string.
			for ( byte b : bytes )
			{
				String hexString = Integer.toHexString( b & 0xff );
				if ( hexString.length() == 1 )
					sb.append( 0 );
				sb.append( hexString );
			}
			return sb.toString();
		}
		catch ( Exception e )
		{
			// In fact, this part of code is unreachable, for algorithm "MD5"
			// and charset "UTF-8" exist exactly.
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		String info = "123456";
		info = MD5.digest(info);
	}
}