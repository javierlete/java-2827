import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDetalleComponent } from './admin-detalle.component';

describe('AdminDetalleComponent', () => {
  let component: AdminDetalleComponent;
  let fixture: ComponentFixture<AdminDetalleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdminDetalleComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminDetalleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
