import { Student } from './student';

describe('Student', () => {
  it('should create an instance', () => {
    expect(new Student('111', 'abcd')).toBeTruthy();
  });
});

describe('Student compute', () => {
  let std = new Student('111', 'abcd');
  it('should compute value', () => {
    expect(std.compute(2)).toBe(3);
    expect(std.compute(-1)).toBe(0);
  });
});
