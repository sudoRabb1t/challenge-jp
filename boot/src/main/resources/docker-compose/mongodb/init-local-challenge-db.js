db = new Mongo().getDB("challengeDB");

db.createCollection('companies', {capped: false});
db.createCollection('transfers', {capped: false});

db.companies.insertMany([
  {
    _id: UUID("11111111-1111-1111-1111-111111111111"),
    cuit: "20304050607",
    name: "Company One",
    registrationDate: new Date("2025-01-15T00:00:00Z")
  },
  {
    _id: UUID("22222222-2222-2222-2222-222222222222"),
    cuit: "30405060708",
    name: "Company Two",
    registrationDate: new Date("2025-02-20T00:00:00Z")
  }
]);

db.transfers.insertMany([
  {
    _id: UUID("33333333-3333-3333-3333-333333333333"),
    transferDate: new Date("2025-02-24T10:00:00Z"),
    amount: 150.75,
    companyId: UUID("11111111-1111-1111-1111-111111111111"),
    debitAccount: "111111",
    creditAccount: "222222"
  },
  {
    _id: UUID("44444444-4444-4444-4444-444444444444"),
    transferDate: new Date("2025-02-25T12:00:00Z"),
    amount: 250.00,
    companyId: UUID("11111111-1111-1111-1111-111111111111"),
    debitAccount: "333333",
    creditAccount: "444444"
  },
  {
    _id: UUID("55555555-5555-5555-5555-555555555555"),
    transferDate: new Date("2025-02-26T15:30:00Z"),
    amount: 500.00,
    companyId: UUID("22222222-2222-2222-2222-222222222222"),
    debitAccount: "555555",
    creditAccount: "666666"
  }
]);
