/*******************************************************************************
 * * Copyright (c) 2015, UIA
 * * All rights reserved.
 * * Redistribution and use in source and binary forms, with or without
 * * modification, are permitted provided that the following conditions are met:
 * *
 * *     * Redistributions of source code must retain the above copyright
 * *       notice, this list of conditions and the following disclaimer.
 * *     * Redistributions in binary form must reproduce the above copyright
 * *       notice, this list of conditions and the following disclaimer in the
 * *       documentation and/or other materials provided with the distribution.
 * *     * Neither the name of the {company name} nor the
 * *       names of its contributors may be used to endorse or promote products
 * *       derived from this software without specific prior written permission.
 * *
 * * THIS SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS "AS IS" AND ANY
 * * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * * DISCLAIMED. IN NO EVENT SHALL THE REGENTS AND CONTRIBUTORS BE LIABLE FOR ANY
 * * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *******************************************************************************/
package uia.utils;

/**
 * Hex string utility.
 * 
 * @author Kyle K. Lin
 */
public class HexStringUtils {

	/**
	 * Convert hex string to byte array.
	 * @param hex Hex string. e.g. 38ff0e2a86
	 * @return Byte array.
	 */
    public static byte[] toBytes(String hex) {
        String data = hex.length() % 2 == 1 ? "0" + hex : hex;
        byte[] result = new byte[data.length() / 2];
        for (int i = 0; i <result.length; i++) {
            result[i] = (byte) Integer.parseInt(data.substring(2 * i, 2 * i + 2), 16);
        }
        return result;
    }
    
    /**
	 * Convert hex string to byte array.
	 * @param hex Hex string. e.g. ab12cd34
     * @param fixAtHead Add '0' at head if this is true or add '0' to tail when length of hex string is odd.
     * @return Byte array.
     */
    public static byte[] toBytes(String hex, boolean fixAtHead) {
        String data = hex.length() % 2 == 1 ? 
        		fixAtHead ? "0" + hex : hex + "0" :  
                hex;
        byte[] result = new byte[data.length() / 2];
        for (int i = 0; i <result.length; i++) {
            result[i] = (byte) Integer.parseInt(data.substring(2 * i, 2 * i + 2), 16);
        }
        return result;
    }
    
    /**
     * Convert hex string to byte array.
	 * @param hex Hex string. e.g. ab-12-cd-34
     * @param split Split string.
     * @return Byte array.
     */
	public static byte[] toBytes(String hex, String split) {
		String[] value = hex.split(split);
		byte[] result = new byte[value.length];
		for (int i = 0; i < value.length; i++) {
			result[i] = (byte) Integer.parseInt(value[i], 16);
		}
		return result;
	}
}