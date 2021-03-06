/*
   Copyright 2018 Callide Technologies LLC

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
  */

package xyz.callide.mesa.data

import xyz.callide.mesa.data.conversion.Converter

/**
  * Represents a single point of data
  *
  * @param value point value
  */

case class DataPoint(value: Option[Any]) {

  /**
    * Converts the data point to the specified type, and makes an assumption that the value exists. Otherwise, an
    * exception is thrown.
    *
    * @param converter implicit converter
    * @tparam A desired data type
    * @return converted point
    */

  def as[A](implicit converter: Converter[A]): A = converter.convert(value.get)

  /**
    * Converts the data point to the specified type, retaining its optional status.
    *
    * @param converter implicit converter
    * @tparam A desired data type
    * @return converted point
    */

  def get[A](implicit converter: Converter[A]): Option[A] = value.map(converter.convert)
}
