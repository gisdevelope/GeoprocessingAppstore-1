/* See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * Esri Inc. licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.esri.gpt.framework.sql;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Text clob mutator.
 */
/* package */ class TextClobMutator implements IClobMutator {

public String get(ResultSet rs, int fieldIndex) throws SQLException {
  return rs.getString(fieldIndex);
}

public String get(ResultSet rs, String fieldName) throws SQLException {
  return rs.getString(fieldName);
}

public void set(PreparedStatement st, int paramIndex, String value) throws SQLException {
  st.setString(paramIndex, value);
}

public InputStream getStream(ResultSet rs, int fieldIndex) throws SQLException {
  final Reader r = rs.getCharacterStream(fieldIndex);
  return new InputStream() {
    @Override
    public int read() throws IOException {
      return r.read();
    }
  };
}

public void setStream(PreparedStatement st, int fieldIndex, InputStream value, long length) throws SQLException {
  st.setCharacterStream(fieldIndex, new InputStreamReader(value), (int) length);
}

}
