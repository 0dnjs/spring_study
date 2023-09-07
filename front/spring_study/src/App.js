import React from "react";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={ <Main/> }/>
        <Route path="/" element={ <List/> }/>
        <Route path="/" element={ <Modification/> }/>
        <Route path="/" element={ <Register/> }/>
        <Route path="/" element={ <Remove/> }/>
      </Routes>
    </>
  );
}

export default App;
