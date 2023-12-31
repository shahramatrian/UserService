// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protos/personal_logger.proto

package com.shahramatrian.intuit;

public interface PersonInfoRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:intuit.PersonInfoRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string first_name = 1;</code>
   * @return The firstName.
   */
  java.lang.String getFirstName();
  /**
   * <code>string first_name = 1;</code>
   * @return The bytes for firstName.
   */
  com.google.protobuf.ByteString
      getFirstNameBytes();

  /**
   * <code>string last_name = 2;</code>
   * @return The lastName.
   */
  java.lang.String getLastName();
  /**
   * <code>string last_name = 2;</code>
   * @return The bytes for lastName.
   */
  com.google.protobuf.ByteString
      getLastNameBytes();

  /**
   * <code>string dob = 3;</code>
   * @return The dob.
   */
  java.lang.String getDob();
  /**
   * <code>string dob = 3;</code>
   * @return The bytes for dob.
   */
  com.google.protobuf.ByteString
      getDobBytes();

  /**
   * <code>string email = 4;</code>
   * @return The email.
   */
  java.lang.String getEmail();
  /**
   * <code>string email = 4;</code>
   * @return The bytes for email.
   */
  com.google.protobuf.ByteString
      getEmailBytes();

  /**
   * <code>string phone_number = 5;</code>
   * @return The phoneNumber.
   */
  java.lang.String getPhoneNumber();
  /**
   * <code>string phone_number = 5;</code>
   * @return The bytes for phoneNumber.
   */
  com.google.protobuf.ByteString
      getPhoneNumberBytes();

  /**
   * <pre>
   *    string timestamp = 6;
   * </pre>
   *
   * <code>.google.protobuf.Timestamp timestamp = 6;</code>
   * @return Whether the timestamp field is set.
   */
  boolean hasTimestamp();
  /**
   * <pre>
   *    string timestamp = 6;
   * </pre>
   *
   * <code>.google.protobuf.Timestamp timestamp = 6;</code>
   * @return The timestamp.
   */
  com.google.protobuf.Timestamp getTimestamp();
  /**
   * <pre>
   *    string timestamp = 6;
   * </pre>
   *
   * <code>.google.protobuf.Timestamp timestamp = 6;</code>
   */
  com.google.protobuf.TimestampOrBuilder getTimestampOrBuilder();
}
