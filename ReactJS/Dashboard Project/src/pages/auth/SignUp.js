import React from "react";
import { Link } from "react-router-dom";

import {
  Button,
  Card,
  CardBody,
  Form,
  FormGroup,
  Label,
  Input,
} from "reactstrap";
import { Formik, FastField, Form, ErrorMessage } from 'formik';
import * as Yup from 'yup';
import { ReactstrapInput } from "reactstrap-formik";
import UserApi from '../../api/UserApi';
import { useState } from "react";
import { withRouter } from "react-router-dom";

const SignUp = () => (
  <React.Fragment>
    <div className="text-center mt-4">
      <h1 className="h2">Get started</h1>
      <p className="lead">Start creating Account in VTI Academy</p>
    </div>
    <Formik
      initialValues={{
        firstName: "",
        lastName: "",
        email: "",
      }}
      validate={(values) => {
        const errors = {};
        // firstname
        if (!values.firstName) {
          errors.firstName = "Required";
        } else if (values.firstName.length < 5) {
          errors.firstName = "Must be 5 characters or greater";
        }
        // lastname
        if (!values.lastName) {
          errors.lastName = "Required";
        } else if (values.lastName.length < 5) {
          errors.lastName = "Must be 5 characters or greater";
        }
        // email
        if (!values.email) {
          errors.email = "Required";
        } else if (
          !/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(values.email)
        ) {
          errors.email = "Invalid email address";
        }

        return errors;
      }}
      onSubmit={(values) => {
        alert(JSON.stringify(values, null, 2));
      }}
    >
      <Card>
        <CardBody>
          <div className="m-sm-4">
            <Form>
              <FormGroup>
                <Label>Fullname</Label>
                <Input
                  bsSize="lg"
                  type="text"
                  name="fullname"
                  placeholder="Enter your Fullname"
                />
              </FormGroup>
              <FormGroup>
                <Label>Username</Label>
                <Input
                  bsSize="lg"
                  type="text"
                  name="username"
                  placeholder="Enter your username"
                />
              </FormGroup>
              <FormGroup>
                <Label>Email</Label>
                <Input
                  bsSize="lg"
                  type="email"
                  name="email"
                  placeholder="Enter your Email"
                />
              </FormGroup>
              <FormGroup>
                <Label>Password</Label>
                <Input
                  bsSize="lg"
                  type="password"
                  name="password"
                  placeholder="Enter password"
                />
              </FormGroup>
              <FormGroup>
                <Label>Comfirm Password</Label>
                <Input
                  bsSize="lg"
                  type="password"
                  name="comfirm_password"
                  placeholder="Enter Comfirm Password"
                />
              </FormGroup>
              <div className="text-center mt-3">
                <Link to="/dashboard/default">
                  <Button color="primary" size="lg">
                    Sign up
                  </Button>
                </Link>
              </div>
            </Form>
          </div>
        </CardBody>
      </Card>
    </Formik>
  </React.Fragment>
);

export default SignUp;
