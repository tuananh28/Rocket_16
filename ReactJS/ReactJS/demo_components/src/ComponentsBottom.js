/* eslint-disable no-unused-vars */
/* eslint-disable no-undef */
import React from "react";

function ComponentsBottom(props) {
  console.log("botttom Data: ", props.data);
  let data = props.data;
  return (
    <div className="row">
      <div className="col-xs-6 col-sm-6 col-md-6 col-lg-6">
        <div className="panel panel-warning">
          <div className="panel-heading">Components_Bottom</div>
          <div className="panel-body">
            <div>
              <textarea
                name=""
                id="input"
                className="form-control"
                rows="3"
                required="required"
              >
                Hello VTI
              </textarea>
              <h5>
                Dữ liệu nhận được từ ComponentsTop:
                <h2>{data}</h2>
              </h5>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ComponentsBottom;
