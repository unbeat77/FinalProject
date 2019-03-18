import { Customer } from './customer';

describe('Customer', () => {
  it('should create an instance', () => {
    expect(new Customer(1,'JOHN',1000,'JOHN@123','JOHN@GMAIL.COM', 432232,'ASDSASDFS')).toBeTruthy();
  });
});
