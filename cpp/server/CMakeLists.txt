# Copyright 2018 gRPC authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
# cmake build file for C++ person example.
# Assumes protobuf and gRPC have been installed using cmake.
# See cmake_externalproject/CMakeLists.txt for all-in-one cmake build
# that automatically builds all the dependencies before building person.

cmake_minimum_required(VERSION 3.8)

project(Person C CXX)

include(../cmake/common.cmake)

# Proto file
get_filename_component(pl_proto "../../protos/personal_logger.proto" ABSOLUTE)
get_filename_component(pl_proto_path "${pl_proto}" PATH)

# Generated sources
set(pl_proto_srcs "${CMAKE_CURRENT_BINARY_DIR}/personal_logger.pb.cc")
set(pl_proto_hdrs "${CMAKE_CURRENT_BINARY_DIR}/personal_logger.pb.h")
set(pl_grpc_srcs "${CMAKE_CURRENT_BINARY_DIR}/personal_logger.grpc.pb.cc")
set(pl_grpc_hdrs "${CMAKE_CURRENT_BINARY_DIR}/personal_logger.grpc.pb.h")
add_custom_command(
      OUTPUT "${pl_proto_srcs}" "${pl_proto_hdrs}" "${pl_grpc_srcs}" "${pl_grpc_hdrs}"
      COMMAND ${_PROTOBUF_PROTOC}
      ARGS --grpc_out "${CMAKE_CURRENT_BINARY_DIR}"
        --cpp_out "${CMAKE_CURRENT_BINARY_DIR}"
        -I "${pl_proto_path}"
        --plugin=protoc-gen-grpc="${_GRPC_CPP_PLUGIN_EXECUTABLE}"
        "${pl_proto}"
      DEPENDS "${pl_proto}")

# Include generated *.pb.h files
include_directories("${CMAKE_CURRENT_BINARY_DIR}")

# pl_grpc_proto
add_library(pl_grpc_proto
  ${pl_grpc_srcs}
  ${pl_grpc_hdrs}
  ${pl_proto_srcs}
  ${pl_proto_hdrs})
target_link_libraries(pl_grpc_proto
  ${_REFLECTION}
  ${_GRPC_GRPCPP}
  ${_PROTOBUF_LIBPROTOBUF})

# Targets plogger_server
foreach(_target
  plogger_server)
  add_executable(${_target} "${_target}.cc")
  target_link_libraries(${_target}
    pl_grpc_proto
    absl::flags
    absl::flags_parse
    ${_REFLECTION}
    ${_GRPC_GRPCPP}
    ${_PROTOBUF_LIBPROTOBUF})
endforeach()
