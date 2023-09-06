#include <iostream>

#include "absl/flags/flag.h"
#include "absl/flags/parse.h"
#include "absl/strings/str_format.h"

#include <grpcpp/grpcpp.h>
#include <grpc/grpc.h>
#include <grpcpp/security/server_credentials.h>
#include <grpcpp/server.h>
#include <grpcpp/server_builder.h>
#include <grpcpp/server_context.h>
#include <google/protobuf/util/time_util.h>

#ifdef BAZEL_BUILD
#include "examples/protos/personal_logger.grpc.pb.h"
#else
#include "personal_logger.grpc.pb.h"
#endif

using grpc::Server;
using grpc::ServerBuilder;
using grpc::ServerContext;
using grpc::Status;
using intuit::PersonLogger;
using intuit::PersonInfoRequest;
using intuit::Response;

ABSL_FLAG(uint16_t, port, 50051, "Server port for the service");

class PersonLoggerImpl final : public PersonLogger::Service {
  Status LogPersonalInfo(ServerContext* context,
                         const PersonInfoRequest* request,
                         Response* response) override {
    std::string prefix("Log: ");

    std::cout << "Peronal details: " << std::endl;
    std::cout << "First name: " << request->first_name() << std::endl;
    std::cout << "Last name: " << request->last_name() << std::endl;
    std::cout << "Date of birth: " << request->dob() << std::endl;
    std::cout << "Email: " << request->email() << std::endl;
    std::cout << "Phone: " << request->phone_number() << std::endl;

    std::string str = google::protobuf::util::TimeUtil::ToString(request->timestamp());
    std::cout << "Added at: " << str << std::endl;

    response->set_message("success");

    Status status(grpc::StatusCode::OK, "No Content");
    return status;
  }
};

void RunServer(uint16_t port) {
  std::string server_address = absl::StrFormat("0.0.0.0:%d", port);
  PersonLoggerImpl service;

  ServerBuilder builder;
  builder.AddListeningPort(server_address, grpc::InsecureServerCredentials());
  builder.RegisterService(&service);
  std::unique_ptr<Server> server(builder.BuildAndStart());
  std::cout << "Server listening on " << server_address << std::endl;
  server->Wait();
}

int main(int argc, char** argv) {
  absl::ParseCommandLine(argc, argv);
  RunServer(absl::GetFlag(FLAGS_port));
  return 0;
}
