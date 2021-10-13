import Api from "./Api";

const url = "/positions";

const getAll = () => {
  return Api.get(url);
};

// export
const PositionsApi = { getAll };
export default PositionsApi;
