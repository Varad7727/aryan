const Seat = require("../model/sit.model");

const getSeatController = async (req, res) => {
  try {
    const tripId = req.params.tripId;
    const seats = await Seat.find({
      tripId: tripId,
    });
    return res.status(200).json({
      Success: true,
      Message: "Seats fetched Successfully!!",
      TotalCount: seats.length,
      Data: seats,
    });
  } catch (error) {
    return res.status(500).json({
      Success: false,
      Message: error.message,
    });
  }
};
module.exports={
    getSeatController
}
