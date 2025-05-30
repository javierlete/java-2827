import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MasMenosComponent } from './mas-menos.component';

describe('MasMenosComponent', () => {
  let component: MasMenosComponent;
  let fixture: ComponentFixture<MasMenosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MasMenosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MasMenosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
