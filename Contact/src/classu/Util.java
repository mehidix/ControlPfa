package classu;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


/* Copyright (c) 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
//package com.google.gdata.util.common.base;


/**
 * Some common string manipulation utilities.
 */
public class Util{

    /**
     * Convert an array of bytes into a List of Strings using UTF-8. A line is
     * considered to be terminated by any one of a line feed ('\n'), a carriage
     * return ('\r'), or a carriage return followed immediately by a linefeed.<p/>
     *
     * Can be used to parse the output of
     *
     * @param bytes the array to convert
     * @return A new mutable list containing the Strings in the input array. The
     *         list will be empty if bytes is empty or if it is null.
     */
    public static List<String> bytesToStringList(byte[] bytes) {
      List<String> lines = new ArrayList<String>();

      if (bytes == null) {
        return lines;
      }

      BufferedReader r = null;

      try {
        r = new BufferedReader(
                new InputStreamReader(
                    new ByteArrayInputStream(bytes),
                    "UTF-8"));
      } catch (UnsupportedEncodingException e) {
        // If UTF-8 is not supported we are in big trouble.
        throw new RuntimeException(e);
      }

      try {
        try {
          for (String line = r.readLine(); line != null; line = r.readLine()) {
            lines.add(line);
          }
        } finally {
          r.close();
        }
      } catch (IOException e) {
        // I can't think of a reason we'd get here.
        throw new RuntimeException(e);
      }

      return lines;
    }

}

