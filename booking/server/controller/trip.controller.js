const Trip = require("../model/trip.model");
const Seat = require("../model/sit.model");

//create trip
const createTripController = async (req, res) => {
  try {
    const body = req.body;
    // Check whether body is an array
    if (!Array.isArray(body) || body.length === 0) {
      return res.status(400).json({
        Success: false,
        Message: "Please send an array of trips",
      });
    }
    for (const trip of body) {
      if (
        !trip?.name ||
        !trip?.source ||
        !trip?.destination ||
        !trip?.price ||
        !trip?.date ||
        !trip?.totalSeats
      ) {
        return res.status(400).json({
          Success: false,
          Message: "All Fields Are Required!!",
        });
      }
    }
    //now insert a trip
    const insertTrip = await Trip.insertMany(body);
    // Create seats for every trip
    let seats = [];
    for (const trip of insertTrip) {
      for (let i = 1; i <= trip.totalSeats; i++) {
        seats.push({
          tripId: trip._id,
          seatNumber: `A${i}`,
          status: "Available",
        });
      }
    }
    await Seat.insertMany(seats);CL
    console.log(insertTrip);
    return res.status(201).json({
      Success: true,
      Message: "Trip Created Successfully!!",
      Data: insertTrip,
    });
  } catch (error) {
    return res.status(201).json({
      Success: false,
      Message: "Trip Failed!!",
    });
  }
};

//get all trips
const getAllTipsController = async (req, res) => {
  try {
    const trips = await Trip.find({});
    return res.status(201).json({
      Success: true,
      Message: "Trip Listed Successfully!!",
      TotalCount: trips.length,
      Data: trips,
    });
  } catch (error) {
    return res.status(201).json({
      Success: false,
      Message: error.message,
    });
  }
};

//get single trip
const getTripById = async (req, res) => {
  try {
    const trip = await Trip.findById(req.params.id);

    if (!trip) {
      return res.status(404).json({
        Success: false,
        Message: "Trip not found",
      });
    }

    return res.status(200).json({
      Success: true,
      Message: "Trip fetched successfully",
      Data: trip,
    });
  } catch (error) {
    return res.status(500).json({
      Success: false,
      Message: error.message,
    });
  }
};

//update
const updateController = async (req, res) => {
  try {
    const id = req.params.id;
    const updateData = req.body;

    const updating = await Trip.updateOne({ _id: id }, { $set: updateData });

    if (updating.matchedCount === 0) {
      return res.status(404).json({
        Success: false,
        Message: "Trip Not Found",
      });
    }

    return res.status(200).json({
      Success: true,
      Message: "Trip Updated Successfully",
      Data: updating,
    });
  } catch (error) {
    return res.status(500).json({
      Success: false,
      Message: error.message,
    });
  }
};

//delete
const deleteTripController = async (req, res) => {
  try {
    const deleted = await Trip.deleteOne({ _id: req.params.id });
    if (deleted.deletedCount > 0) {
      return res.status(200).json({
        Success: true,
        Message: "Trip deleted",
      });
    }
    return res.status(404).json({
      Success: false,
      Message: "Trip not found",
    });
  } catch (error) {
    return res.status(500).json({
      Success: false,
      Message: error.message,
    });
  }
};

module.exports = {
  createTripController,
  getAllTipsController,
  getTripById,
  updateController,
  deleteTripController,
};
