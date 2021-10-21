import React from "react";
import { useState } from "react";

function Hook1() {
  const [Count, setCount] = useState(0);
  return (
    <div className="row">
      <div className="col-xs-6 col-sm-6 col-md-6 col-lg-6">
        <button
          type="button"
          className="btn btn-success"
          onClick={() => setCount(Count + 1)}
        >
          Click
        </button>
      </div>
      <div className="col-xs-6 col-sm-6 col-md-6 col-lg-6">
        <p style={{ fontSize: "50" }}>Bạn đã click {Count} lần.</p>
      </div>
    </div>
  );
}
export default Hook1;
